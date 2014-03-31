package ar.edu.unq.desapp

import java.awt.Image

class Book {
	val title : String
	val isbn : String
	val editorial : String
	var image : Image
	var description : String
	val authors: List[Author] 
}