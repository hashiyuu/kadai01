package com.example.kadai01

import android.graphics.Color
import android.icu.text.CaseMap
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.kadai01.databinding.FragmentKadaiEditBinding
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import java.lang.IllegalArgumentException
import java.text.ParseException
import kotlin.coroutines.coroutineContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KadaiEditFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KadaiEditFragment : Fragment() {
    private var _binding: FragmentKadaiEditBinding? = null
    private val binding get() = _binding!!

    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        realm = Realm.getDefaultInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKadaiEditBinding.inflate(inflater, container, false)
        return binding.root
    }


    private fun Kadai(view: View) {
        realm.executeTransaction { db: Realm ->
            val maxId = db.where<Kadai>().max("id")
            val nextId = (maxId?.toLong() ?: 0L) + 1L
            val kadai = db.createObject<Kadai>(nextId)
            kadai.title = binding.titleEdit.text.toString()
            kadai.id = binding.idEdit.text.toString()
            kadai.pass = binding.passEdit.text.toString()
        }
        Snackbar.make(view, "入力しました。", Snackbar.LENGTH_SHORT)
            .setAction("戻る") { findNavController().popBackStack() }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}
