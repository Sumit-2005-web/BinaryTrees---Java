# 🌳 Binary Trees in Java

This repository contains a comprehensive journey of learning and implementing **Binary Trees in Java**, starting from basic tree construction to solving advanced tree-based problems.

## 📌 Table of Contents

- [Introduction](#introduction)
- [Tree Construction](#tree-construction)
- [Basic Operations](#basic-operations)
- [Traversals](#traversals)
- [Advanced Questions](#advanced-questions)
  - [1. Kth Ancestor of a Node](#1-kth-ancestor-of-a-node)
  - [2. Transform to Sum Tree](#2-transform-to-sum-tree)
  - [3. Lowest Common Ancestor (LCA)](#3-lowest-common-ancestor-lca)
  - [4. Print Kth Level Nodes](#4-print-kth-level-nodes)
  - [5. Top View of Binary Tree](#5-top-view-of-binary-tree)
- [How to Run](#how-to-run)
- [Contributing](#contributing)
- [License](#license)

---

## 📖 Introduction

A **Binary Tree** is a hierarchical data structure in which each node has at most two children: left and right. It is widely used in coding interviews and system design.

---

## 🌱 Tree Construction

- Creating nodes using a class `Node`
- Building tree manually or using array input
- Recursive tree builders

```java
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
