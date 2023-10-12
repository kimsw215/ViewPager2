import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2.DataVo.AimyonData
import com.example.viewpager2.databinding.Viewpager2ListItemBinding


class ViewPagerDiffUtilAdapter : ListAdapter<AimyonData, ViewPagerDiffUtilAdapter.ItemViewHolder>(DiffCallback) {
    private lateinit var binding: Viewpager2ListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = Viewpager2ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(private val binding: Viewpager2ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AimyonData) {
            binding.ivImage.setImageResource(item.Image)
            binding.ivName.text = item.name
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<AimyonData>() {
        override fun areItemsTheSame(oldItem: AimyonData, newItem: AimyonData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: AimyonData, newItem: AimyonData): Boolean {
            return oldItem.name == newItem.name
        }

    }
}