package pk.inlab.app.managedata.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import pk.inlab.app.managedata.R
import pk.inlab.app.managedata.data.Medicine

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Using view model
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.medicineData.observe(this, Observer {
            for(data in it){
                Log.e("medicine_logging", "Name: ${data.name}, Dosage: ${data.dosage}, Duration: ${data.duration}")
            }
        })

        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
