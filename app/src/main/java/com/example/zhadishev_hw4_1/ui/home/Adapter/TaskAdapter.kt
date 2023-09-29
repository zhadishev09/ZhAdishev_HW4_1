package com.example.zhadishev_hw4_1.ui.home.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.zhadishev_hw4_1.databinding.ItemTaskBinding
import com.example.zhadishev_hw4_1.model.Task

class TaskAdapter: Adapter<TaskAdapter.TaskViewHolder>() {

    private val list = arrayListOf<Task>()

    fun setData(data: Task) {
        list.add(0,data)
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list[position])
    }



    inner class TaskViewHolder(private val binding:ItemTaskBinding):ViewHolder(binding.root){
        fun bind(task: Task){
            binding.tvTitle.text = task.title
            binding.tvDesk.text = task.desc
            if(adapterPosition%2==0){
                itemView.setBackgroundColor(Color.BLACK)
                binding.tvDesk.setTextColor(Color.WHITE)
                binding.tvTitle.setTextColor(Color.WHITE)
            }

        }

    }
}