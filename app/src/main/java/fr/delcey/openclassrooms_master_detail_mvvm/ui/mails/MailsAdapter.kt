package fr.delcey.openclassrooms_master_detail_mvvm.ui.mails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.delcey.openclassrooms_master_detail_mvvm.databinding.MailsItemBinding

class MailsAdapter: ListAdapter<MailViewState, MailsAdapter.ViewHolder>(MailsDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        MailsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: MailsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MailViewState) {
            binding.mailsItemTextView.text = item.title
            binding.mailsItemTextView.setOnClickListener {
                item.onMailClicked.invoke()
            }
        }
    }

    object MailsDiffCallback : DiffUtil.ItemCallback<MailViewState>() {
        override fun areItemsTheSame(oldItem: MailViewState, newItem: MailViewState): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MailViewState, newItem: MailViewState): Boolean = oldItem == newItem
    }
}