package com.jdc.mkt.sealedClasses;

public class Main {

}

record OtherNode () implements MyInter {}
final class SingleNode extends Node{}
final class PairNode extends Node{}

sealed interface MyInter permits OtherNode {}
sealed class Node permits SingleNode,PairNode{}
