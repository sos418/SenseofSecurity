package com.example.a1216qdf.senseofsecurity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.qozix.tileview.TileView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MarkFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MarkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MarkFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CheckBox checkBoxBathroom;
    public CheckBox checkBoxWater,checkBoxGarbage,checkBoxSomke,checkBoxWatch,checkBoxCar,checkBoxNobathroom
            ,checkBoxNight,checkBoxLove,checkBoxSafe;
    public TileView tileView;
    public ImageView bathroomImg,bathroomImg1,bathroomImg2,bathroomImg3,bathroomImg4,bathroomImg5,bathroomImg6,waterImg,waterImg1,waterImg2,waterImg3,waterImg4,waterImg5,waterImg6;
    public ImageView garbageImg,garbageImg1,garbageImg2,garbageImg3,garbageImg4,garbageImg5,garbageImg6;
    public ImageView smokeImg,smokeImg1,watchImg,watchImg1,watchImg2,watchImg3,watchImg4,watchImg5,watchImg6,carImg,carImg1,nightImg,nightImg1,loveImg,loveImg1,safeImg;


    private OnFragmentInteractionListener mListener;

    public MarkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MarkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MarkFragment newInstance(String param1, String param2) {
        MarkFragment fragment = new MarkFragment();
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

        View v = inflater.inflate(R.layout.fragment_mark,container,false);


        checkBoxBathroom = (CheckBox)v.findViewById(R.id.checkboxBathroom);
//        if (checkBoxBathroom.isChecked())
//            checkBoxBathroom.setButtonDrawable(R.drawable.pushbathroom);
//        else
//            checkBoxBathroom.setButtonDrawable(R.drawable.nbathroom);

//        checkBoxBathroom.setButtonDrawable(R.drawable.nbathroom);
        checkBoxWater = (CheckBox)v.findViewById(R.id.checkboxWater);
        checkBoxGarbage = (CheckBox)v.findViewById(R.id.checkboxGarbage);
        checkBoxSomke = (CheckBox)v.findViewById(R.id.checkboxSmoke);
        checkBoxWatch = (CheckBox)v.findViewById(R.id.checkboxWatch);
        checkBoxCar = (CheckBox)v.findViewById(R.id.checkboxCar);
        checkBoxNight = (CheckBox)v.findViewById(R.id.checkboxNight);
        checkBoxLove = (CheckBox)v.findViewById(R.id.checkboxLove);
        checkBoxSafe = (CheckBox)v.findViewById(R.id.checkboxSafe);

        checkBoxBathroom.setOnCheckedChangeListener(checkListener);
        checkBoxWater.setOnCheckedChangeListener(checkListener);
        checkBoxGarbage.setOnCheckedChangeListener(checkListener);
        checkBoxSomke.setOnCheckedChangeListener(checkListener);
        checkBoxWatch.setOnCheckedChangeListener(checkListener);
        checkBoxCar.setOnCheckedChangeListener(checkListener);
        checkBoxNight.setOnCheckedChangeListener(checkListener);
        checkBoxLove.setOnCheckedChangeListener(checkListener);
        checkBoxSafe.setOnCheckedChangeListener(checkListener);



        // Inflate the layout for this fragment
        return v;
    }

    private CheckBox.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.checkboxBathroom:
                    if (checkBoxBathroom.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);
                        bathroomImg = new ImageView(getActivity());
                        bathroomImg.setImageResource(R.drawable.mbathroom);
                        bathroomImg1 = new ImageView(getActivity());
                        bathroomImg1.setImageResource(R.drawable.mbathroom);
                        bathroomImg2 = new ImageView(getActivity());
                        bathroomImg2.setImageResource(R.drawable.mbathroom);
                        bathroomImg3 = new ImageView(getActivity());
                        bathroomImg3.setImageResource(R.drawable.mbathroom);
                        bathroomImg4 = new ImageView(getActivity());
                        bathroomImg4.setImageResource(R.drawable.mbathroom);
                        bathroomImg5 = new ImageView(getActivity());
                        bathroomImg5.setImageResource(R.drawable.mbathroom);
                        bathroomImg6 = new ImageView(getActivity());
                        bathroomImg6.setImageResource(R.drawable.mbathroom);
                        tileView.addMarker( bathroomImg, 121.266343, 24.970440, null, null );
                        tileView.addMarker( bathroomImg1, 121.267496, 24.970761, null, null );
                        tileView.addMarker( bathroomImg2, 121.268091, 24.970270, null, null );
                        tileView.addMarker( bathroomImg3, 121.268231, 24.969326, null, null );
                        tileView.addMarker( bathroomImg4, 121.266777, 24.969365, null, null );
                        tileView.addMarker( bathroomImg5, 121.266772, 24.968694, null, null );
                        tileView.addMarker( bathroomImg6, 121.268505, 24.966292, null, null );



                    }
                    else {
                        removePin(bathroomImg);
                        removePin(bathroomImg1);
                        removePin(bathroomImg2);
                        removePin(bathroomImg3);
                        removePin(bathroomImg4);
                        removePin(bathroomImg5);
                        removePin(bathroomImg6);

                    }
                    break;
                case R.id.checkboxWater:
                    if (checkBoxWater.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        waterImg = new ImageView(getActivity());
                        waterImg.setImageResource(R.drawable.mwater);
                        waterImg1 = new ImageView(getActivity());
                        waterImg1.setImageResource(R.drawable.mwater);
                        waterImg2 = new ImageView(getActivity());
                        waterImg2.setImageResource(R.drawable.mwater);
                        waterImg3 = new ImageView(getActivity());
                        waterImg3.setImageResource(R.drawable.mwater);
                        waterImg4 = new ImageView(getActivity());
                        waterImg4.setImageResource(R.drawable.mwater);
                        waterImg5 = new ImageView(getActivity());
                        waterImg5.setImageResource(R.drawable.mwater);
                        waterImg6 = new ImageView(getActivity());
                        waterImg6.setImageResource(R.drawable.mwater);
                        tileView.addMarker( waterImg, 121.266505, 24.970440, null, null );
                        tileView.addMarker( waterImg1, 121.267656, 24.970761, null, null );
                        tileView.addMarker( waterImg2, 121.268241, 24.970270, null, null );
                        tileView.addMarker( waterImg3, 121.268381, 24.969326, null, null );
                        tileView.addMarker( waterImg4, 121.266927, 24.969365, null, null );
                        tileView.addMarker( waterImg5, 121.266922, 24.968694, null, null );
                        tileView.addMarker( waterImg6, 121.268655, 24.966292, null, null );

                    }
                    else {
                        removePin(waterImg);
                        removePin(waterImg1);
                        removePin(waterImg2);
                        removePin(waterImg3);
                        removePin(waterImg4);
                        removePin(waterImg5);
                        removePin(waterImg6);
                    }
                    break;
                case R.id.checkboxGarbage:
                    if (checkBoxGarbage.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        garbageImg = new ImageView(getActivity());
                        garbageImg.setImageResource(R.drawable.mgarbage);
                        garbageImg1 = new ImageView(getActivity());
                        garbageImg1.setImageResource(R.drawable.mgarbage);
                        garbageImg2 = new ImageView(getActivity());
                        garbageImg2.setImageResource(R.drawable.mgarbage);
                        garbageImg3 = new ImageView(getActivity());
                        garbageImg3.setImageResource(R.drawable.mgarbage);
                        garbageImg4 = new ImageView(getActivity());
                        garbageImg4.setImageResource(R.drawable.mgarbage);
                        garbageImg5 = new ImageView(getActivity());
                        garbageImg5.setImageResource(R.drawable.mgarbage);
                        garbageImg6 = new ImageView(getActivity());
                        garbageImg6.setImageResource(R.drawable.mgarbage);
                        tileView.addMarker( garbageImg, 121.266655, 24.970440, null, null );
                        tileView.addMarker( garbageImg1, 121.267806, 24.970761, null, null );
                        tileView.addMarker( garbageImg2, 121.268391, 24.970270, null, null );
                        tileView.addMarker( garbageImg3, 121.268531, 24.969326, null, null );
                        tileView.addMarker( garbageImg4, 121.267077, 24.969365, null, null );
                        tileView.addMarker( garbageImg5, 121.267072, 24.968694, null, null );
                        tileView.addMarker( garbageImg6, 121.268805, 24.966292, null, null );
                    }
                    else {
                        tileView.removeMarker(garbageImg);
                        tileView.removeMarker(garbageImg1);
                        tileView.removeMarker(garbageImg2);
                        tileView.removeMarker(garbageImg3);
                        tileView.removeMarker(garbageImg4);
                        tileView.removeMarker(garbageImg5);
                        tileView.removeMarker(garbageImg6);

                    }
                    break;
                case R.id.checkboxSmoke:
                    if (checkBoxSomke.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        smokeImg = new ImageView(getActivity());
                        smokeImg.setImageResource(R.drawable.msmoke);
                        smokeImg1 = new ImageView(getActivity());
                        smokeImg1.setImageResource(R.drawable.msmoke);
                        tileView.addMarker( smokeImg, 121.266477, 24.969197, null, null );
                        tileView.addMarker( smokeImg1, 121.268593, 24.969520, null, null );


                    }
                    else {
                        tileView.removeMarker(smokeImg);
                        tileView.removeMarker(smokeImg1);
                    }
                    break;
                case R.id.checkboxWatch:
                    if (checkBoxWatch.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);
                        watchImg = new ImageView(getActivity());
                        watchImg.setImageResource(R.drawable.mwatch);
                        watchImg1 = new ImageView(getActivity());
                        watchImg1.setImageResource(R.drawable.mwatch);
                        watchImg2 = new ImageView(getActivity());
                        watchImg2.setImageResource(R.drawable.mwatch);
                        tileView.addMarker( watchImg, 121.266805, 24.970440, null, null );
                        tileView.addMarker( watchImg1, 121.267956, 24.970761, null, null );
                        tileView.addMarker( watchImg2, 121.268541, 24.970270, null, null );

                    }
                    else {
                        tileView.removeMarker(watchImg);
                        tileView.removeMarker(watchImg1);
                        tileView.removeMarker(watchImg2);
                    }
                    break;
                case R.id.checkboxCar:
                    if (checkBoxCar.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        carImg = new ImageView(getActivity());
                        carImg.setImageResource(R.drawable.mcar);
                        carImg1 = new ImageView(getActivity());
                        carImg1.setImageResource(R.drawable.mcar);
                        tileView.addMarker( carImg, 121.268030, 24.971113, null, null );
                        tileView.addMarker( carImg1, 121.265720, 24.970443, null, null );

                    }
                    else {
                        tileView.removeMarker(carImg);
                        tileView.removeMarker(carImg1);
                    }
                    break;
                case R.id.checkboxNight:
                    if (checkBoxNight.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        nightImg = new ImageView(getActivity());
                        nightImg.setImageResource(R.drawable.mnight);
                        nightImg1 = new ImageView(getActivity());
                        nightImg1.setImageResource(R.drawable.mnight);
                        tileView.addMarker( nightImg, 121.269342, 24.967134, null, null );
                        tileView.addMarker( nightImg1, 121.266124, 24.967961, null, null );

                    }
                    else {
                        tileView.removeMarker(nightImg);
                        tileView.removeMarker(nightImg1);
                    }
                    break;
                case R.id.checkboxLove:
                    if (checkBoxLove.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        loveImg = new ImageView(getActivity());
                        loveImg.setImageResource(R.drawable.mlove);
                        loveImg1 = new ImageView(getActivity());
                        loveImg1.setImageResource(R.drawable.mlove);
                        tileView.addMarker( loveImg, 121.268341, 24.970320, null, null );
                        tileView.addMarker( loveImg1, 121.267908, 24.965833, null, null );

                    }
                    else {
                        tileView.removeMarker(loveImg);
                        tileView.removeMarker(loveImg1);
                    }
                    break;
                case R.id.checkboxSafe:
                    if (checkBoxSafe.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        safeImg = new ImageView(getActivity());
                        safeImg.setImageResource(R.drawable.msafe);
                        tileView.addMarker( safeImg, 121.267392, 24.965668, null, null );

                    }
                    else {
                        tileView.removeMarker(safeImg);
                    }
                    break;
            }
        }
    };


    private void removePin(ImageView imageView ){
        tileView.removeMarker(imageView);
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
        points.add( new double[] {1, 2} );
        points.add( new double[] {3,6} );
        points.add( new double[] {7, 11} );
        points.add( new double[] {20,20} );
        points.add( new double[] {50, 50} );
        points.add( new double[] {60,90} );
        points.add( new double[] {100,150} );
        points.add( new double[] {200, 250} );
        points.add( new double[] {300, 388} );
        points.add( new double[] {1000,1000} );
        points.add( new double[] {1555,1500} );

    }
}
