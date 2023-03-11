package com.example.todoappkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import com.example.todoappkotlin.databinding.FragmentNewTodofragmentBinding
import com.example.todoappkotlin.dialogs.DatePickerDialogFragment
import com.example.todoappkotlin.dialogs.TimePickerDialogFragment
import com.example.todoappkotlin.utils.getFormatedDateTime
import com.example.todoappkotlin.utils.priority_normal


class NewTodofragment : Fragment() {
    private  lateinit var binding: FragmentNewTodofragmentBinding
    private  var priority = priority_normal
    private  var DateInMillis =System.currentTimeMillis()
    private var timeInMillies =System.currentTimeMillis()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTodofragmentBinding.inflate(inflater,container,false)
        binding.PriorityRG.setOnCheckedChangeListener { radioGroup, i ->
            val rb = radioGroup.findViewById<RadioButton>(i);
            priority =rb.text.toString()
            Toast.makeText(activity,priority,Toast.LENGTH_SHORT).show()


        }

        binding.timeBtn.setOnClickListener {
            TimePickerDialogFragment{timeStamp->
                timeInMillies =timeStamp
                binding.timeBtn.text= getFormatedDateTime(timeInMillies,"hh:m a")

            }.show(childFragmentManager,"time_picker")


        }
        binding.dateBtn.setOnClickListener {
            DatePickerDialogFragment{timestamp->
                DateInMillis =timestamp
                binding.dateBtn.text=getFormatedDateTime(DateInMillis,"dd:MM:yyyy")
            }.show(childFragmentManager,"date_picker")

        }
        binding.saveBtn.setOnClickListener {
            val todoName = binding.toDoInputET.text.toString()
            if(todoName.isEmpty()){
                binding.toDoInputET.error= "please provide a valid todo name"
                return@setOnClickListener
            }
        }

    return  binding.root

    }


}