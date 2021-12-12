package com.adventofcode.model

trait Puzzle[P1, P2] {
  def part1(input: Seq[String]): P1
  def part2(input: Seq[String]): P2

  def solve(resource: Seq[String]): (P1, P2) = {
    val result1 = part1(resource)
    val result2 = part2(resource)
    (result1, result2)
  }
}