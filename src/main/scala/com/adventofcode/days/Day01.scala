package com.adventofcode.days

import com.adventofcode.model.Puzzle

object Day01 extends Puzzle[Int, Int] {

  override def part1(input: Seq[String]): Int =
    countIncreases(input.map(_.toInt))

  override def part2(input: Seq[String]): Int =
    countIncreases(input.map(_.toInt).sliding(3).toList.map(_.sum))

  def countIncreases (input: Seq[Int]): Int =
    input.drop(1).foldLeft[(Int, Int)]((0, input.head)) { (acc, i) =>
      if (i > acc._2) (acc._1 + 1, i) else (acc._1, i)
    }._1
}
