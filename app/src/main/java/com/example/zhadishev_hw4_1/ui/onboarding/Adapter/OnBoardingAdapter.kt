package com.example.zhadishev_hw4_1.ui.onboarding.Adapter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.zhadishev_hw4_1.databinding.ItemOnboardingBinding
import com.example.zhadishev_hw4_1.model.OnBoarding
import com.example.zhadishev_hw4_1.utils.loadImage

class OnBoardingAdapter(private val onClick:()->Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    val data = arrayListOf(
        OnBoarding("https://cdn-icons-png.flaticon.com/512/4345/4345573.png", "Title 1", "Desk 1"),
        OnBoarding("https://cdn-icons-png.flaticon.com/512/2098/2098402.png", "Title 2", "Desk 2"),
        OnBoarding("https://www.cflowapps.com/wp-content/uploads/2021/12/diffnce_job_task_process.jpeg", "Title 3", "Desk 3"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
        val d = OnBoarding("Image", "5", "6")
    }




    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding)
        :ViewHolder(binding.root){

        fun bind(onBoarding: OnBoarding){
            binding.ivBoard.loadImage(onBoarding.image)
            binding.btnStart.setOnClickListener{
                onClick()
            }
            binding.tvSkip.setOnClickListener {
                onClick()
            }
            binding.btnStart.isVisible=adapterPosition ==data.lastIndex
                binding.tvTitle.text = onBoarding.title
                binding.tvDesk.text = onBoarding.desk


            }

        }


}