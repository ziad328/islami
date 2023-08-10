package com.example.islami.ui.home.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.ui.hadeethDetails.HadeethDetailsActivity
import com.example.islami.ui.home.adapter.HadeethNamesAdapter


class HadeethFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HadeethNamesAdapter
    private val names: MutableList<String> = ArrayList()

    companion object {
        val HADEETH_POSITION = "hadeeth position"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeeth, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (i in 1..50) {
            names.add(getString(R.string.hadeeth_number) + " " + i)
        }

        recyclerView = requireView().findViewById(R.id.rv_hadeeth)
        adapter = HadeethNamesAdapter(names)
        adapter.onHadeethClick = { position ->
            showHadeethDetails(position)
        }
        recyclerView.adapter = adapter


    }

//    private fun readFromFile(fileName: String):List<String> {
//        val fileContent = requireActivity().application.assets.open(fileName).bufferedReader().use{
//            it.readText()
//        }
//
//        return  fileContent.split("#")
//    }

//    private fun getTitles(hadeeths:List<String>, position:Int){
//
//        for (hadeeth in hadeeths){
//            hadeeth.split("\n")[position]
//        }
//    }
//
//    private fun getHadeethContent(hadeeths:List<String>){
//        for (hadeeth in hadeeths){
//            this.hadeeth.add(hadeeth.split("\n")[0])
//        }
//    }

    private fun showHadeethDetails(position: Int) {
        val intent = Intent(requireContext(), HadeethDetailsActivity::class.java)
        intent.putExtra(HADEETH_POSITION, position)
        startActivity(intent)

    }
}