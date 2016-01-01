package io.github.e0en

import processing.core._

import scala.math._
import scala.util.Random

/* A simple app that runs processing sketch.
 * Most of code taken from
 * - https://gist.github.com/b-studios/8559107
 * - http://va.lent.in/scala-processing/
 */
class Test extends PApplet {
  var angle = 0

  override def settings(): Unit = {
    size(640, 360)
  }

  override def setup(): Unit = {
    background(102)
    smooth()
    noStroke()
    fill(0, 102)
  }

  override def draw(): Unit = {
    angle += 10
    val value = cos(toRadians(angle)) * 6.0
    for (a <- 0 to 360 by 75) {
      val xoff = cos(toRadians(a)) * value
      val yoff = sin(toRadians(a)) * value
      fill(Random.nextInt(255))
      ellipse( (mouseX + xoff).toFloat, (mouseY + yoff).toFloat, value.toFloat, value.toFloat )
    }
    fill(255)
    ellipse(mouseX, mouseY, 2, 2)
  }
}

object Test extends App {
  PApplet.main("io.github.e0en.Test")
}
