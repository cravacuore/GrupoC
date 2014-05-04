package ar.edu.unq.desapp.model.bean

import org.joda.time.DateTime

class Comment(
	val anUser: User,
	val comment: String,
	val date: DateTime
)