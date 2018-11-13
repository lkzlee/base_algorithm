package com.lkzlee.algorithm;

import java.util.HashMap;
import java.util.Map;

/***
 * @author:lkzlee
 * @date: 2018/11/13 14:20
 * @Desc:
 */
public class LRUCache<T>
{
	public static class Node<T>
	{
		Node prev;
		Node next;
		String key;
		T value;

		public Node(String key, T t)
		{
			this.key = key;
			this.value = t;
			this.prev = this.next = null;
		}
	}

	Node<T> head;
	Node<T> tail;
	Map<String, Node<T>> map = new HashMap<String, Node<T>>();
	int cacheSize = Integer.MAX_VALUE;

	public LRUCache(int cacheSize)
	{
		this.cacheSize = cacheSize;
		head = new Node<>(null, null);
		tail = new Node<>(null, null);
		head.next = tail;
		tail.prev = head;
	}

	public LRUCache()
	{
		head = new Node<>(null, null);
		tail = new Node<>(null, null);
		head.next = tail;
		tail.prev = head;
	}

	public Node<T> get(String key)
	{
		if (!map.containsKey(key))
			return null;
		Node node = map.get(key);
		if (node == null)
			return null;
		node.next.prev = node.prev;
		node.prev.next = node.next;
		appendTail(node);
		return node;

	}

	private void appendTail(Node node)
	{
		node.next = tail;
		node.prev = tail.prev;
		tail.prev.next = node;
		tail.prev = node;
	}

	public void put(String key, T value)
	{
		if (map.containsKey(key))
		{
			Node<T> node = map.get(key);
			node.value = value;
			node.prev.next = node.next;
			node.next.prev = node.prev;
			appendTail(node);
			return;
		}
		if (map.size() >= cacheSize)
		{
			Node tmp = head.next;
			tmp.prev.next = tmp.next;
			tmp.next.prev = tmp.prev;
			map.remove(tmp.key);
		}
		Node<T> node = new Node<T>(key, value);
		appendTail(node);
		map.put(key, node);
	}

	public void printNode()
	{
		Node p = head.next;
		do
		{
			System.out.print(p.key + ":" + p.value + "->");
			p = p.next;
		}
		while (p != tail);
		System.out.println();
	}

	public static void main(String[] args)
	{
		LRUCache cache = new LRUCache<String>();
		cache.put("name", "lkzlee");
		cache.put("age", "lkde");
		cache.put("address", "1254");
		cache.put("ddbv", "134");
		cache.put("ttw", "3512");
		cache.printNode();
		cache.get("address");
		cache.printNode();
	}
}
