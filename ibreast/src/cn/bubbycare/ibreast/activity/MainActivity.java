package cn.bubbycare.ibreast.activity;

import java.util.HashMap;
import java.util.Random;
import org.json.JSONObject;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.data.Constants;
import cn.bubbycare.ibreast.interfaces.IActivity;
import cn.bubbycare.ibreast.utils.AccessTokenKeeper;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuth;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQAuth;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

public class MainActivity extends BaseActivity implements IActivity, OnClickListener {

    private static String APPKEY = "8839ed2ba098";
    private static String APPSECRET = "315a824f2eed0bc6366478248320816a";
    private static final String[] AVATARS = { "http://tupian.qqjay.com/u/2011/0729/e755c434c91fed9f6f73152731788cb3.jpg",
            "http://99touxiang.com/public/upload/nvsheng/125/27-011820_433.jpg", "http://img1.touxiang.cn/uploads/allimg/111029/2330264224-36.png",
            "http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339485237265.jpg",
            "http://diy.qqjay.com/u/files/2012/0523/f466c38e1c6c99ee2d6cd7746207a97a.jpg", "http://img1.touxiang.cn/uploads/20121224/24-054837_708.jpg",
            "http://img1.touxiang.cn/uploads/20121212/12-060125_658.jpg", "http://img1.touxiang.cn/uploads/20130608/08-054059_703.jpg",
            "http://diy.qqjay.com/u2/2013/0422/fadc08459b1ef5fc1ea6b5b8d22e44b4.jpg", "http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339510584349.jpg",
            "http://img1.touxiang.cn/uploads/20130515/15-080722_514.jpg", "http://diy.qqjay.com/u2/2013/0401/4355c29b30d295b26da6f242a65bcaad.jpg" };

//    private UMSocialService mController = UMServiceFactory.getUMSocialService(Constants.DESCRIPTOR);

    Button btnLogin;
    Button btnRegister;
    ImageButton imgBtnQQ;
    ImageButton imgBtnWB;
	public static QQAuth mQQAuth;
	private UserInfo mInfo;
	private Tencent mTencent;
	private final String APP_ID = "222222";// 测试时使用，真正发布的时候要换成自己的APP_ID
	public static String mAppid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        SMSSDK.initSDK(this, APPKEY, APPSECRET);
        initView();
        initValue();
        initEvent();
    	// 创建微博实例
    	mWeiboAuth = new WeiboAuth(this, Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE);
//        addQQQZonePlatform();
    }
    


    @Override
    public void initView() {
        // TODO Auto-generated method stub
        btnLogin = (Button) this.findViewById(R.id.activity_main_btn_login);
        btnRegister = (Button) this.findViewById(R.id.activity_main_btn_register);
        imgBtnQQ = (ImageButton)this.findViewById(R.id.activity_main_login_qq);
        imgBtnWB = (ImageButton)this.findViewById(R.id.activity_main_login_wb);
    }

    @Override
    public void initValue() {
        // TODO Auto-generated method stub

    }

    @Override
    public void initEvent() {
        // TODO Auto-generated method stub
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        imgBtnQQ.setOnClickListener(this);
        imgBtnWB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
        case R.id.activity_main_btn_login:

            break;
        case R.id.activity_main_btn_register:
            register();
            break;
        case R.id.activity_main_login_qq:
//            login(SHARE_MEDIA.QQ);
        	onClickLogin();
            break;
        case R.id.activity_main_login_wb:
        	wbLogin();
        	break;
        
        default:
            break;
        }
    }
    
    /** 微博 Web 授权类，提供登陆等功能  */
    private WeiboAuth mWeiboAuth;
    
    /** 封装了 "access_token"，"expires_in"，"refresh_token"，并提供了他们的管理功能  */
    private Oauth2AccessToken mAccessToken;

    /** 注意：SsoHandler 仅当 SDK 支持 SSO 时有效 */
    private SsoHandler mSsoHandler;
    private void wbLogin()
    {
//    	// 创建微博实例
//    	mWeiboAuth = new WeiboAuth(this, Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE);
        mSsoHandler = new SsoHandler(MainActivity.this, mWeiboAuth);
        mSsoHandler.authorize(new AuthListener());
    }
    
    /**
     * 微博认证授权回调类。
     * 1. SSO 授权时，需要在 {@link #onActivityResult} 中调用 {@link SsoHandler#authorizeCallBack} 后，
     *    该回调才会被执行。
     * 2. 非 SSO 授权时，当授权结束后，该回调就会被执行。
     * 当授权成功后，请保存该 access_token、expires_in、uid 等信息到 SharedPreferences 中。
     */
    class AuthListener implements WeiboAuthListener {
        
        @Override
        public void onComplete(Bundle values) {
            // 从 Bundle 中解析 Token
            mAccessToken = Oauth2AccessToken.parseAccessToken(values);
            if (mAccessToken.isSessionValid()) {
                // 显示 Token
                
                // 保存 Token 到 SharedPreferences
                AccessTokenKeeper.writeAccessToken(MainActivity.this, mAccessToken);
                Toast.makeText(MainActivity.this, 
                        "成功", Toast.LENGTH_SHORT).show();
            } else {
                // 以下几种情况，您会收到 Code：
                // 1. 当您未在平台上注册的应用程序的包名与签名时；
                // 2. 当您注册的应用程序包名与签名不正确时；
                // 3. 当您在平台上注册的包名和签名与您当前测试的应用的包名和签名不匹配时。
                String code = values.getString("code");
                String message = "消息";
                if (!TextUtils.isEmpty(code)) {
                    message = message + "\nObtained the code: " + code;
                }
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onCancel() {
            Toast.makeText(MainActivity.this, 
                    "取消", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onWeiboException(WeiboException e) {
            Toast.makeText(MainActivity.this, 
                    "Auth exception : " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    
	private void onClickLogin() {
		if (!mQQAuth.isSessionValid()) {
			IUiListener listener = new BaseUiListener() {
				@Override
				protected void doComplete(JSONObject values) {
				}
			};
			mQQAuth.login(this, "all", listener);
			// mTencent.loginWithOEM(this, "all",
			// listener,"10000144","10000144","xxxx");
			mTencent.login(this, "all", listener);
		} else {
			mQQAuth.logout(this);
		}
	}
    
	/**
	 * QQ第三方登录的相关接口
	 */
	private class BaseUiListener implements IUiListener {

		@Override
		public void onComplete(Object response) {
//			Util.showResultDialog(MainActivity.this, response.toString(),
//					"登录成功");
			Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
			doComplete((JSONObject) response);
		}

		protected void doComplete(JSONObject values) {

		}

		@Override
		public void onError(UiError e) {
			Toast.makeText(MainActivity.this, "数据错误", Toast.LENGTH_SHORT).show();

		}

		@Override
		public void onCancel() {
			Toast.makeText(MainActivity.this,"操作取消爱哦", Toast.LENGTH_SHORT).show();

		}
	}

	
	@Override
	protected void onStart() {
		final Context context = MainActivity.this;
		final Context ctxContext = context.getApplicationContext();
		mAppid = APP_ID;
		mQQAuth = QQAuth.createInstance(mAppid, ctxContext);
		mTencent = Tencent.createInstance(mAppid, MainActivity.this);
		super.onStart();
	}

    private void register() {
        try {
            // 打开注册页面
            RegisterPage registerPage = new RegisterPage();
            registerPage.setRegisterCallback(new EventHandler() {
                public void afterEvent(int event, int result, Object data) {
                    // 解析注册结果
                    if (result == SMSSDK.RESULT_COMPLETE) {
                        @SuppressWarnings("unchecked")
                        HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                        String country = (String) phoneMap.get("country");
                        String phone = (String) phoneMap.get("phone");
                        // 提交用户信息
                        registerUser(country, phone);

                        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                        startActivity(intent);
                    } else {

                    }
                }
            });
            registerPage.show(MainActivity.this);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // 提交用户信息
    private void registerUser(String country, String phone) {
        Random rnd = new Random();
        int id = Math.abs(rnd.nextInt());
        String uid = String.valueOf(id);
        String nickName = "SmsSDK_User_" + uid;
        String avatar = AVATARS[id % 12];
        SMSSDK.submitUserInfo(uid, nickName, avatar, country, phone);
    }
}
