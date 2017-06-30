package summer

import org.joda.time.Days.daysBetween
import org.joda.time.{DateTime, Days, Hours}

class Countdown {
  val date = DateTime.now()

  override def toString:String = {
    date.toString
  }
}

object Countdown extends Countdown {

  def daysLeft(d:DateTime):Days = daysBetween(date, d)
}



