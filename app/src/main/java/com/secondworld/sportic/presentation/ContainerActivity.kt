package com.secondworld.sportic.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.secondworld.sportic.presentation.screens.map.MapActivity
import com.secondworld.sportic.databinding.ActivityMainBinding

@SuppressLint("SetTextI18n", "MissingPermission")
class ContainerActivity : AppCompatActivity()
//    , LocationListener
{

    // TODO: нужно сделать кнопку по которой будет стартовать запись трека и кнопку по которой будет останавливаться запись трека
    // TODO: нужно сделать лампочку и секундомер сколько идет запись

    private lateinit var binding: ActivityMainBinding

//    private lateinit var locationManager: LocationManager
//    private val locationPermissionCode = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        title = "Определение текущих координат"
//
//        binding.getLocation.setOnClickListener {
//            getLocation()
//        }
    }

//    private fun getLocation(): Location? {
//
//        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
//            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionCode)
//        }
//
//        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//
//        // TODO: нужно по кнопке менять активность
//        val isGPSEnabled: Boolean = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
//
//
//        if (isGPSEnabled) {
//
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 5f, this)
//            return locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
//
//        } else {
//            Snackbar.make(binding.parentLayout, "Пожалуйста, включите GPS!", Snackbar.LENGTH_LONG).show()
//        }
//        return null
//
//    }

//    override fun onLocationChanged(location: Location) {
//
//        Snackbar.make(binding.parentLayout, "Complete", Snackbar.LENGTH_LONG).show()
//
////        binding.textView.text =
////            "Latitude: " + location.latitude + " , Longitude: " + location.longitude
//
//        val intent = Intent(this, MapActivity::class.java)
//        intent.putExtra("lat", location.latitude)
//        intent.putExtra("lon", location.longitude)
//        startActivity(intent)
//    }

//    @SuppressLint("MissingSuperCall")
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        if (requestCode == locationPermissionCode) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Snackbar.make(binding.parentLayout, "Permission Granted", Snackbar.LENGTH_LONG).show()
//            } else {
//                Snackbar.make(binding.parentLayout, "Permission Denied", Snackbar.LENGTH_LONG).show()
//            }
//        }
//    }
}