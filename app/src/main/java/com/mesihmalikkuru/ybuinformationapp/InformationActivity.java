package com.mesihmalikkuru.ybuinformationapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class InformationActivity extends AppCompatActivity {

    AnnouncementCombiner ac;
    TextView tvTitle;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        ac = (AnnouncementCombiner) getIntent().getExtras().get("announcement combiner");

        tvInfo = (TextView) findViewById(R.id.tv_info);
        tvTitle = (TextView) findViewById(R.id.tv_info_title);

        tvTitle.setText(ac.getName());

        new Information().execute();

    }

    private String findInfoFromUrl(String url) throws IOException {

        Document document = Jsoup.connect(url).get();

        Elements contentLeft = document.select("div#content_left");
        Elements p = contentLeft.get(0).select("p");

        String fullText = "";

        for (int i = 1; i < p.size(); i++) {

            if(i == 1) {
                fullText = p.get(i).text();
            } else if(i == p.size() - 1) {
                fullText = fullText + p.get(i).text();
            } else {
                fullText = fullText + "\n\n" + p.get(i).text();
            }
        }

        return fullText;

    }

    private class Information extends AsyncTask<Void, Void, Void> {

        String allData = "";

        @Override
        protected Void doInBackground(Void... params) {

            try {
                allData = findInfoFromUrl(ac.getAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            tvInfo.setText(allData);

        }
    }
}
