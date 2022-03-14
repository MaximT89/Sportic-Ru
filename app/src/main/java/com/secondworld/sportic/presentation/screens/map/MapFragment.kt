package com.secondworld.sportic.presentation.screens.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.secondworld.sportic.R
import com.secondworld.sportic.core.BaseFragment
import com.secondworld.sportic.databinding.FragmentMapBinding

class MapFragment : BaseFragment<FragmentMapBinding>(), OnMapReadyCallback {

    private val viewModel : MapViewModel by viewModels()
    private lateinit var mMap: GoogleMap
    private var lat : Double? = null
    private var lon : Double? = null

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMapBinding.inflate(inflater, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lat = arguments?.getDouble("lat", 0.0)
        lon = arguments?.getDouble("lon", 0.0)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {

        val mapFragment = childFragmentManager.findFragmentById(R.id.map1) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap



//        val polylineOptions = PolylineOptions()
//            .add(LatLng(37.35, -122.0))
//            .add(LatLng(37.45, -122.0)) // North of the previous point, but at the same longitude
//            .add(LatLng(37.45, -122.2)) // Same latitude, and 30km to the west
//            .add(LatLng(37.35, -122.2)) // Same longitude, and 16km to the south
//            .add(LatLng(37.35, -122.0)) // Closes the polyline.
//
//        val polyline = mMap.addPolyline(polylineOptions)
//        Add a marker in Sydney and move the camera

        val sydney = LatLng(lat!!, lon!!)
        mMap.addMarker(
            MarkerOptions()
                .position(sydney)
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15f))

//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(polyline.points[0], 15f))
    }

}