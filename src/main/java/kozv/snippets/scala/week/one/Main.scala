package kozv.snippets.scala.week.one

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0) 1 else if (c > r) 0 else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

    @tailrec def balanceRecur(char: List[Char], counter: Int): Boolean = {
      if (counter < 0) false
      else if (char.isEmpty && counter == 0) true
      else if (char.head == '(') balanceRecur(char.tail, counter + 1)
      else if (char.head == ')') balanceRecur(char.tail, counter - 1)
      else balanceRecur(char.tail, counter)
    }
    balanceRecur(chars, 0)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) return 1
    if (money < 0  || coins.isEmpty) return 0
    countChange(money - coins.head,  coins) + countChange(money, coins.tail)
  }
}