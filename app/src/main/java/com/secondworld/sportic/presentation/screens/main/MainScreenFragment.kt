package com.secondworld.sportic.presentation.screens.main

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.material.snackbar.Snackbar
import com.secondworld.sportic.R
import com.secondworld.sportic.core.BaseFragment
import com.secondworld.sportic.databinding.FragmentMainScreenBinding
import com.secondworld.sportic.presentation.screens.map.MapActivity
import com.secondworld.sportic.presentation.screens.map.MapFragment

@SuppressLint("SetTextI18n", "MissingPermission")
class MainScreenFragment : BaseFragment<FragmentMainScreenBinding>(), LocationListener {

    private val viewModel : MainScreenViewModel by viewModels()

    private lateinit var locationManager: LocationManager
    private val locationPermissionCode = 2

    // TODO: нужно сделать кнопку по которой будет стартовать запись трека и кнопку по которой будет останавливаться запись трека
    // TODO: нужно сделать лампочку и секундомер сколько идет запись


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        binding.getLocation.setOnClickListener {
            getLocation()
        }
    }

    private fun getLocation(): Location? {

        if ((ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionCode)
        }

        locationManager = requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager

        // TODO: нужно по кнопке менять активность
        val isGPSEnabled: Boolean = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)


        if (isGPSEnabled) {

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 5f, this)
            return locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)

        } else {
            Snackbar.make(binding.parentLayout, "Пожалуйста, включите GPS!", Snackbar.LENGTH_LONG).show()
        }
        return null

    }

    override fun onLocationChanged(location: Location) {

        Snackbar.make(binding.parentLayout, "Complete", Snackbar.LENGTH_LONG).show()

//        binding.textView.text =
//            "Latitude: " + location.latitude + " , Longitude: " + location.longitude

        val bundle = Bundle()
        bundle.putDouble("lat", location.latitude)
        bundle.putDouble("lon", location.longitude)

        setFragmentResult("result", bundle)
        findNavController().navigate(R.id.mapFragment)
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == locationPermissionCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Snackbar.make(binding.parentLayout, "Permission Granted", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(binding.parentLayout, "Permission Denied", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMainScreenBinding.inflate(inflater, container, false)

}