package cn.bubbycare.ibreast.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 *  for opera small data
 * @author xushiyong
 *
 */
public class SPDB {

    private final static String name = "spdb.db";

    /**
     * setValue for String type
     * 
     * @param context
     * @param key
     * @param value
     * @return success or fail
     */
    public static boolean setValue(Context context, String key, String value) {
        try {
            SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
            Editor editor = preferences.edit();
            editor.putString(key, value);
            editor.commit();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }

    /**
     * get Value for String type
     * @param context
     * @param key
     * @return default value is null
     */
    public static String getStringValue(Context context,String key)
    {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getString(key, null);
    }

    /**
     * setValue for int type
     * 
     * @param context
     * @param key
     * @param value
     * @return success or fail
     */
    public static boolean setValue(Context context, String key, int value) {
        try {
            SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
            Editor editor = preferences.edit();
            editor.putInt(key, value);
            editor.commit();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }
    
    /**
     * get Value for boolean type
     * @param context
     * @param key
     * @return  default value is 0
     */
    public static int getIntValue(Context context,String key)
    {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getInt(key, 0);
    }


    /**
     * setValue for float type
     * 
     * @param context
     * @param key
     * @param value
     * @return success or fail
     */
    public static boolean setValue(Context context, String key, float value) {
        try {
            SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
            Editor editor = preferences.edit();
            editor.putFloat(key, value);
            editor.commit();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }
    
    /**
     * get Value for float type
     * @param context
     * @param key
     * @return  default value is 0.0f
     */
    public static float getFloatValue(Context context,String key)
    {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getFloat(key, 0.0f);
    }

    /**
     * setValue for boolean type
     * 
     * @param context
     * @param key
     * @param value
     * @return success or fail
     */
    public static boolean setValue(Context context, String key, boolean value) {
        try {
            SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
            Editor editor = preferences.edit();
            editor.putBoolean(key, value);
            editor.commit();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }

    /**
     * get Value for boolean type
     * @param context
     * @param key
     * @return  default value is false
     */
    public static boolean getBooleanValue(Context context,String key)
    {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }
    
}
