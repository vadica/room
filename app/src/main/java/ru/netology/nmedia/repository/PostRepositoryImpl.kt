package ru.netology.nmedia.repository

import androidx.lifecycle.Transformations
import ru.netology.nmedia.Post
import ru.netology.nmedia.dao.PostDao
import ru.netology.nmedia.entity.PostEntity

class PostRepositoryImpl(
    private val dao: PostDao
) : PostRepository {
    override fun getAll() = Transformations.map(dao.getAll()) { list ->
        list.map {
            Post(it.id, it.author, content = it.content, published = it.published, likedByMe = it.likedByMe, likeCount = it.likeCount, shareCount = it.shareCount )
        }
    }

    override fun likeById(id: Long) {
        dao.likeById(id)
    }

    override fun shareById(id: Long) {
        dao.shareById(id)
    }

    override fun removeById(id: Long) {
        dao.removeById(id)
    }

    override fun save(post: Post) {
        dao.save(PostEntity.fromDto(post))
    }

}