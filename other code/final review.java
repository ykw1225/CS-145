Final review:
2:
	public void trim(int min, int max){
		overallRoot = trim(min, max, overallRoot);
	}
	private IntTree trim(int min, int max, IntTree root){
		if(root != null){
			if(root.data<min){
				return trim(min,max,root.right);
			}else if(root.data>max){
				return trim(min,max,root.left);
			}
			root.left = trim(min,max,root.left);
			root.right = trim(min,max,root.right);
		}
		return root;
	}

3:
	public int countLeftNodes(){
		return countLeftNodes(overallRoot);
	}
	private int countLeftNodes(IntTree root){
		if(root != null){
			if(root.left != null){
				return 1+countLeftNodes(root.left);
			}
			else{
				return 0;
			}
		}
		else{
			return 0;
		}
	}

4:
	public int countMultiples(int n){
		if(n == 0){
			throw new IllegalArgumentException();
		}
		return countMunltiples(n, overallRoot);
	}
	private int countMultiples(int n, IntTree root){
		if(root!= null){
			if(root.data % n == 0){
				return 1+countMultiples(n, root.left)+countMultiples(n, root.right);
			}
			else{
				return 0;
			}
		}
		else{
			return 0;
		}
	}

5:
	public Map<Point, int> pointCount(List<Point, int> list){
		Map<Point, int> map = new HashMap<Point, int>();
		for(Point p: list){
			if(!map.containsKey(p)){
				map.put(p, 1);
			}
			else{
				map.put(p, map.get(p)+1);
			}
		}
		return map;
	}

6:
	public boolean equals(Set<int> s1, Set<int> s2){
		if(s1.size() != s2.size){
			return false;
		}
		for(int n: s1){
			if(!s2.contains(n)){
				return false;
			}
		}
		return true;
	}

7:
	public int multiplyEvens(int n){
		if(n < 1){
			throw IllegalArgumentException();
		}
		else{
			int result = 1;
			for(int i = 2; n > 0; i+=2, n-=1){
				result *= i;
			}
			return result;
		}
	}
