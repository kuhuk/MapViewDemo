package com.sharma.kuhuk.mapviewdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class FacebookSignIn extends AppCompatActivity {

    private static final String TAG = "hash";
    private static final String EMAIL = "email";
    CallbackManager callbackManager;
    ImageView fb, ivUserPicture;
    TextView tvUserName;
    String id, name, email, birthday;
    Profile profile;
    Uri personPhoto;
    URL profile_pic;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_facebook_sign_in);
        hideStatusnActionBars();
        setupUIViews();
        fbSignIn();
    }

    private void setupUIViews() {
        fb = findViewById(R.id.fb);
        tvUserName = findViewById(R.id.tvUserName);
        ivUserPicture = findViewById(R.id.ivUserPicture);
        btnLogout = findViewById(R.id.btnLogout);
    }

    public void onClick(View v) {
        if (v == fb) {
            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("user_photos", "email", "user_birthday", "public_profile"));
        }

        if (v == btnLogout) {
            LoginManager.getInstance().logOut();
        }
    }

    private void fbSignIn () {
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                String accessToken = loginResult.getAccessToken().getToken();
                Log.i("accessToken", accessToken);

                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {@Override
                        public void onCompleted(JSONObject object, GraphResponse response) {

                            Log.i("LoginActivity",
                                    response.toString());
                            try {
                                id = object.getString("id");
                                try {
                                    profile_pic = new URL("http://graph.facebook.com/" + id + "/picture?type=large");
                                    Log.i("profile_pic", profile_pic + "");
                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                }
                                name = object.getString("name");
                                email = object.getString("email");
                                birthday = object.getString("birthday");
                                updateUI(profile_pic, name ,email ,birthday);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id, name, email, gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Log.e("Error(Facebook Login)", error.getCause().toString());
            }
        });
    }

    private void updateUI(URL profile_pic, String name, String email, String birthday) {
        tvUserName.setText(name);
        Uri image = Profile.getCurrentProfile().getProfilePictureUri(200, 200);
        Picasso.with(FacebookSignIn.this).load(image).into(ivUserPicture);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        profile = Profile.getCurrentProfile().getCurrentProfile();
        if (profile != null) {
            // user has logged in
        } else {
            // user has not logged in
        }
    }

    private void hideStatusnActionBars () {
        // Hide the status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        //Hide the action bar
        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.hide();
    }
}
