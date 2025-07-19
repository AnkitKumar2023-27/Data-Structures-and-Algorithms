class NumArray {
    int n;
    int[] tree;

    public NumArray(int[] nums) {
        this.n = nums.length;
        tree = new int[4 * n];
        buildTree(0, 0, n - 1, nums);
    
    }

    private void buildTree(int i, int start, int end, int[] arr) {
        if (start == end) {
            tree[i] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        buildTree(2 * i + 1, start, mid, arr);
        buildTree(2 * i + 2, mid + 1, end, arr);
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    public void update(int index, int val) {
        
        updateUtil(0, 0, n - 1, val, index);
    }


  private void updateUtil(int i, int si, int sj, int val, int index) {
    if (si == sj) {
        tree[i] = val;
        return;
    }

    int mid = (si + sj) / 2;
    if (index <= mid) {
        updateUtil(2 * i + 1, si, mid, val, index);
    } else {
        updateUtil(2 * i + 2, mid + 1, sj, val, index);
    }
    tree[i] = tree[2 * i + 1] + tree[2 * i + 2];  
}

    public int sumRange(int left, int right) {
        return sumRangeUtil(0, 0, n - 1, left, right);
    }

    private int sumRangeUtil(int i, int si, int sj, int qi, int qj) {
        if (qj < si || qi > sj) {
            return 0;
        }

        if (si >= qi && sj <= qj) {
            return tree[i];
        }

        int mid = (si + sj) / 2;
        int leftAns = sumRangeUtil(2 * i + 1, si, mid, qi, qj);
        int rightAns = sumRangeUtil(2 * i + 2, mid + 1, sj, qi, qj);
        return leftAns + rightAns;
    }
}
