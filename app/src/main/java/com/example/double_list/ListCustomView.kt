package com.example.double_list

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.withStyledAttributes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.double_list.databinding.BaseListBinding

internal class ListCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes){

    private val binding: BaseListBinding

    var isLoading: Boolean = false
        set(value) {
            field = value
            updateListState()
        }

    var title: CharSequence? = null
        set(value) {
            field = value
            binding.questionsTitle.text = value
        }

    init {
        binding = BaseListBinding.inflate(
            /* inflater = */ LayoutInflater.from(context),
            /* parent = */ this,
            /* attachToParent = */ true
        )

        initializeArguments(attrs, defStyleAttr, defStyleRes)
        updateListState()
    }

    private fun initializeArguments(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        val list = this

        context.withStyledAttributes(attrs, R.styleable.ListCustomView, defStyleAttr, defStyleRes) {
            list.apply {
                title = getString(R.styleable.ListCustomView_title) ?: list.title
                isLoading = getBoolean(R.styleable.ListCustomView_item_is_loading, list.isLoading)
            }
        }
    }

    private fun updateListState() {
        when {
            isLoading -> showLoading()
            else -> showRequestInfo()
        }
    }

    private fun showLoading() {
        //binding.content. -> placeholder
    }

    private fun showRequestInfo() {
        updateListInfo()
        //binding.placeholder -> content
    }

    fun updateListInfo() {
        binding.questionsList.layoutManager = LinearLayoutManager(context)
        binding.questionsList.adapter = ListAdapter(
            listOf(
                ListEntry(
                    title = "1234",
                    descriprion = "5678"
                ),
                ListEntry(
                    title = "9101",
                    descriprion = "11213"
                ),
                ListEntry(
                    title = "14151",
                    descriprion = "61718"
                ),
                ListEntry(
                    title = "19202",
                    descriprion = "12223"
                ),
                ListEntry(
                    title = "24252",
                    descriprion = "62728"
                )
            )
        )
    }
}