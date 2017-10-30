package com.udacity.stockhawk.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.udacity.stockhawk.R;

import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailStock extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_stock);
        ButterKnife.bind(this);

        String[] stock = getIntent().getStringArrayExtra(Intent.EXTRA_TEXT);
        setTitle(stock[1]);
        WebSettings webSettings = mWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("empyrean-aurora-455.appspot.com")
                .appendPath("charts.php")
                .appendQueryParameter("symbol", stock[0]);
        String url = builder.build().toString();
        mWebview.loadUrl(url);
    }
}
