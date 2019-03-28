package cn.itcast.crawler.autohome.util;

import java.util.BitSet;

import org.apache.commons.lang3.StringUtils;

//去重过滤器，布隆过滤器
public class IdFilter {

	/* BitSet初始分配2^24个bit */
	private static final int DEFAULT_SIZE = 1 << 24;

	/* 不同哈希函数的种子，一般应取质数 */
	private static final int[] seeds = new int[] { 5, 7, 11, 13, 31, 37 };

	private BitSet bits = new BitSet(DEFAULT_SIZE);

	/* 哈希函数对象 */
	private SimpleHash[] func = new SimpleHash[seeds.length];

	public IdFilter() {
		for (int i = 0; i < seeds.length; i++) {
			func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
		}
	}

	// 将id标记到bits中
	public void add(String str) {
		for (SimpleHash f : func) {
			bits.set(f.hash(str), true);
		}
	}

	// 判断id是否已经被bits标记
	public boolean contains(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		}

		boolean ret = true;
		for (SimpleHash f : func) {
			ret = ret && bits.get(f.hash(str));
		}

		return ret;
	}

	/* 哈希函数类 */
	public static class SimpleHash {
		private int cap;
		private int seed;

		public SimpleHash(int cap, int seed) {
			this.cap = cap;
			this.seed = seed;
		}

		// hash函数，采用简单的加权和hash
		public int hash(String value) {
			int result = 0;
			int len = value.length();
			for (int i = 0; i < len; i++) {
				result = seed * result + value.charAt(i);
			}
			return (cap - 1) & result;
		}
	}
	
	public static void main(String[] args) {
		IdFilter i = new IdFilter();
		Integer i1 = 203243;
		Integer i2 = 204535;
		Integer i3 = 352351;
		Integer i4 = 203243;
		i.add(i1.toString());
		i.add(i2.toString());
		i.add(i3.toString());
		System.out.println(i.contains(i4.toString()));
	}
	
}
