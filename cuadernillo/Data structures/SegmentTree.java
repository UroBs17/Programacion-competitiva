static class SegmentTree {
	    int start, end;
	    SegmentTree leftTree, rightTree;
	    int value;

	    public SegmentTree(int start, int end) {
	        this.start = start;
	        this.end = end;
	        this.value = 1;
	        if(start == end) {  // es una hoja
	            leftTree = rightTree = null;
	            return;
	        }
	        int mid = (start + end) / 2;
	        leftTree = new SegmentTree(start, mid);
	        rightTree = new SegmentTree(mid + 1, end);
	    }
	    
	    public void set(int pos, int value) {
	    	// es una hoja, CASO BASE
	        if(start == end) {
	            this.value = value;
	            return;
	        }
	        int mid = (start + end) / 2;
	        if(pos <= mid) leftTree.set(pos, value);
	        else rightTree.set(pos, value);
	        this.value = leftTree.value*rightTree.value;

	    }
	    public int getValue(int low, int high) {
	    	if(start == low && end == high) return value;
	        int mid = (start + end) / 2;
	        // [low,high] totalmente incluido en [start,mid]
	        if(high <= mid) return leftTree.getValue(low, high);
	        // [low,high] totalmente incluido en [mid+1,end]
	        if(low > mid)return rightTree.getValue(low, high);
	        // debemos dividir el intervalo en [low,mid] y [mid+1,high]
	        int leftMin = leftTree.getValue(low, mid);
	        int rightMin = rightTree.getValue(mid+1, high);
	        return leftMin* rightMin;

	    }
	}
