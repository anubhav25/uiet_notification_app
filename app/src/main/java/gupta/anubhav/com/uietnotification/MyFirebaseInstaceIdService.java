package gupta.anubhav.com.uietnotification;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ANUBHAV on 25-Dec-16.
 */

public class MyFirebaseInstaceIdService extends FirebaseInstanceIdService {
    private static final String RegToken="REG_TOKEN";
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String recentToken= FirebaseInstanceId.getInstance().getToken();
        VolleyHelper vh = new VolleyHelper(this);
        JSONObject j = new JSONObject();
        try {
            j.put("token",recentToken);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        vh.post("addNewToken",j,null,null);
        Log.d(RegToken,recentToken);
    }
}
