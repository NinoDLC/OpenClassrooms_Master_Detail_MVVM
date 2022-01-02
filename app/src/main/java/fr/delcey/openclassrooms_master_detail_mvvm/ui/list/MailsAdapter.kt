package fr.delcey.openclassrooms_master_detail_mvvm.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.delcey.openclassrooms_master_detail_mvvm.databinding.ListItemBinding

class MailsAdapter(
    private val listener: (id: String) -> Unit
) : ListAdapter<MailViewState, MailsAdapter.ViewHolder>(MailsDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MailViewState, listener: (id: String) -> Unit) {
            binding.listItemTv.text = item.title
            binding.listItemTv.setOnClickListener {
                listener.invoke(item.id)
            }
        }
    }

    object MailsDiffCallback : DiffUtil.ItemCallback<MailViewState>() {
        override fun areItemsTheSame(oldItem: MailViewState, newItem: MailViewState): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MailViewState, newItem: MailViewState): Boolean = oldItem == newItem
    }
}