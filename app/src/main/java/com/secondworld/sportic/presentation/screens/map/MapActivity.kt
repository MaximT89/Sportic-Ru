package com.secondworld.sportic.presentation.screens.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import com.secondworld.sportic.R

class MapActivity : AppCompatActivity(), OnMapReadyCallback
{

    private lateinit var mMap: GoogleMap
    private var lat : Double? = null
    private var lon : Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val intent = intent
        lat = intent.getDoubleExtra("lat", 0.0)
        lon = intent.getDoubleExtra("lon", 0.0)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val polylineOptions = PolylineOptions()
            .add(LatLng(37.35, -122.0))
            .add(LatLng(37.45, -122.0)) // North of the previous point, but at the same longitude
            .add(LatLng(37.45, -122.2)) // Same latitude, and 30km to the west
            .add(LatLng(37.35, -122.2)) // Same longitude, and 16km to the south
            .add(LatLng(37.35, -122.0)) // Closes the polyline.

        val polyline = mMap.addPolyline(polylineOptions)

//        Add a marker in Sydney and move the camera
//        val sydney = LatLng(lat!!, lon!!)
//        mMap.addMarker(
//            MarkerOptions()
//                .position(sydney)
//        )
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15f))

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(polyline.points[0], 15f))
    }

}