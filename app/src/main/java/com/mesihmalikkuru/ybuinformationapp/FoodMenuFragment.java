package com.mesihmalikkuru.ybuinformationapp;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FoodMenuFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FoodMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodMenuFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    static final String URL =  "http://ybu.edu.tr/sks/";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private Document doc;

    public FoodMenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodMenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodMenuFragment newInstance(String param1, String param2) {
        FoodMenuFragment fragment = new FoodMenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        new Foods().execute();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_menu, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private class Foods extends AsyncTask<Void, Void, Void> {

        String Yemek1;
        String Yemek2;
        String Yemek3;
        String Yemek4;

        TextView tvYemek1;
        TextView tvYemek2;
        TextView tvYemek3;
        TextView tvYemek4;

        @Override
        protected Void doInBackground(Void... params) {

            try {

                Document document = Jsoup.connect(URL).get();
                Elements tbody = document
                        .select("tbody");
                Elements tr = tbody.get(1).select("tr");

                Elements td = tr.get(2).select("td");
                Elements h5 = td.get(0).select("h5");
                Yemek1 = h5.text();

                td = tr.get(3).select("td");
                h5 = td.get(0).select("h5");
                Yemek2 = h5.text();

                td = tr.get(4).select("td");
                h5 = td.get(0).select("h5");
                Yemek3 = h5.text();

                td = tr.get(5).select("td");
                h5 = td.get(0).select("h5");
                Yemek4 = h5.text();




            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            tvYemek1 = (TextView) getView().findViewById(R.id.tv_yemek_1);
            tvYemek2 = (TextView) getView().findViewById(R.id.tv_yemek_2);
            tvYemek3 = (TextView) getView().findViewById(R.id.tv_yemek_3);
            tvYemek4 = (TextView) getView().findViewById(R.id.tv_yemek_4);

            tvYemek1.setText(Yemek1);
            tvYemek2.setText(Yemek2);
            tvYemek3.setText(Yemek3);
            tvYemek4.setText(Yemek4);

        }
    }
}
