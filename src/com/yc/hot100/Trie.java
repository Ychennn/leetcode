package com.yc.hot100;

class Trie {//实现Trie(前缀树)⭐⭐⭐⭐⭐

    private class TrieNode {
        private boolean isEnd;//标记当前是否为结束点
        //并不直接存放字符串,而是用对应位的TrieNode是否为空来代表是否有该值
        private TrieNode[] next;

        public TrieNode() {
            this.isEnd = false;
            this.next = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new TrieNode();
            }
            curr = curr.next[c - 'a'];
        }
        curr.isEnd = true;//⭐⭐⭐
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                return false;
            }
            curr = curr.next[c - 'a'];
        }
        //如apple,结尾元素为e,此时包含apple但不包含app,因为p的isEnd为false
        //不仅包含全部元素,且结尾元素的isEnd必须为true
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                return false;
            }
            curr = curr.next[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));//返回true
        System.out.println(trie.search("app"));//返回false
        System.out.println(trie.startsWith("app")); //返回true
        trie.insert("app");
        System.out.println(trie.search("app"));//返回ture
    }
}