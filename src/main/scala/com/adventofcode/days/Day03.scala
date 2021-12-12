package com.adventofcode.days

import com.adventofcode.model.Puzzle

object Day03 extends Puzzle[Int, Int] {


  override def part1(input: Seq[String]): Int =
    input.map(_.toList).transpose.map {
      col =>
        val zerosCount = col.count(_.asDigit == 0)
        val onesCount = col.count(_.asDigit == 1)
        if (zerosCount > onesCount) Seq(0, 1) else Seq(1, 0)
    }.transpose.map(b => Integer.parseInt(b.mkString, 2)).product

  override def part2(input: Seq[String]): Int =
    0
}
