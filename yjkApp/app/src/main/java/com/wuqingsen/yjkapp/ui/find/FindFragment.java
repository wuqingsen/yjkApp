package com.wuqingsen.yjkapp.ui.find;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wuqingsen.yjkapp.R;
import com.wuqingsen.yjkapp.common.base.BaseFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FindFragment extends BaseFragment {

    @Override
    protected int setLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void setData() {

    }

}
