package com.xammy.mvvmarchitecture.base.diffutils

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.DiffUtil
import com.android.boilerplate.R
import com.android.boilerplate.base.view.BaseAdapter
import com.android.boilerplate.base.view.BaseViewHolder
import com.android.boilerplate.databinding.ItemUserBinding
import com.android.boilerplate.model.data.local.database.entities.User

/**
 * @author Abdul Rahman
 */
class UsersAdapter(
    private val context: Context,
    private val listener: ((user: User) -> Unit)? = null
) : BaseAdapter<ItemUserBinding, User, UsersAdapter.UserViewHolder>(UserDiffCallback()) {

    override fun getInflater(): LayoutInflater {
        return LayoutInflater.from(context)
    }

    override fun getLayoutId(): Int {
        return R.layout.item_user
    }

    override fun createViewHolder(binding: ItemUserBinding): BaseViewHolder<ItemUserBinding> {
        return UserViewHolder(binding)
    }

    inner class UserViewHolder(private val binding: ItemUserBinding) :
        BaseViewHolder<ItemUserBinding>(binding) {

        override fun bind(position: Int) {
            binding.apply {
                val userToBind = getItem(position)
                user = userToBind
                executePendingBindings()
                itemView.setOnClickListener {
                    listener?.let {
                        it(userToBind)
                    }
                }
            }
        }
    }

    private class UserDiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}