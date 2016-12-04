package com.example.a1216qdf.senseofsecurity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.qozix.tileview.TileView;
import com.qozix.tileview.paths.CompositePathView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RouteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RouteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RouteFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CheckBox LightRuoute,RunRoute;
    public TileView tileView;

    public List<double[]> sub,sub1 ;
    private OnFragmentInteractionListener mListener;
    private CompositePathView.DrawablePath drawablePath,drawablePath11;

    public RouteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RouteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RouteFragment newInstance(String param1, String param2) {
        RouteFragment fragment = new RouteFragment();
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_route,container,false);
        LightRuoute = (CheckBox)view.findViewById(R.id.checkboxbrightroute);
        RunRoute = (CheckBox)view.findViewById(R.id.checkboxrunroute);
        LightRuoute.setOnCheckedChangeListener(checklist1);
        RunRoute.setOnCheckedChangeListener(checklist1);

        // Inflate the layout for this fragment
        return view;
    }

    private CheckBox.OnCheckedChangeListener checklist1 = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.checkboxbrightroute:
                    if (LightRuoute.isChecked())
                    {
                        DrawLightRoute();
                    }
                    else {
                        RemoveRoute();
                    }
                    break;
                case R.id.checkboxrunroute:
                    if (RunRoute.isChecked())
                    {
                        DrawrRunRoute();
                    }
                    else {
                        RemoveRunRoute();
                    }
                    break;

            }
        }
    };

    private void DrawLightRoute(){
        tileView = (TileView)getActivity().findViewById(R.id.tileView);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        drawablePath = tileView.drawPath(points.subList(0, 5), paint);
        tileView.drawPath(drawablePath);

        //錯誤寫法
//        CompositePathView.DrawablePath drawablePath = (CompositePathView.DrawablePath) points.subList(1,5);
//        tileView.drawPath(drawablePath);
    }

    private void RemoveRoute(){
        tileView.removePath(drawablePath);
    }

    private void DrawrRunRoute(){
        tileView = (TileView)getActivity().findViewById(R.id.tileView);

        Paint paint1 = new Paint();
        paint1.setAntiAlias(true);
        paint1.setColor(Color.BLACK);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(10);
        drawablePath11 = tileView.drawPath(points.subList(5, 7), paint1);
        tileView.drawPath(drawablePath11);

    }


    private void RemoveRunRoute(){
        tileView.removePath(drawablePath11);
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    // a list of points to demonstrate markers and paths
    private ArrayList<double[]> points = new ArrayList<>();

    {
        //明亮
        points.add( new double[] {121.263579,24.970100} );
        points.add( new double[] {121.267350,24.970100} );
        points.add( new double[] {121.267350,24.969900} );
        points.add( new double[] {121.267600, 24.969700} );
        points.add( new double[] {121.267600, 24.967450} );
        //運動
        points.add( new double[] {121.268720, 24.967400} );
        points.add( new double[] {121.268720, 24.966600} );
        points.add( new double[] {965, 1772} );
        points.add( new double[] {965, 2036} );
        points.add( new double[] {965, 2441} );

    }

}
