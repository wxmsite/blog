package com.blog.pagehelper;

import java.util.List;

/**
 * author bebetter159
 * date  2018/5/22 18:59
 */

/**
 * 主要是因为使用PageHelper对solr数据分页时遇到了bug,所以就决定自己写一个分页
 *
 * @param <T>
 */
public class Page<T> {
    //每页显示的数据量，可封装一个类初始化它的值
    private int pageSize = 20;
    private int currentPage;
    private int firstPage;
    private int prePage;
    private int nextPage;
    private int lastPage;

    private boolean hasPreviousPage;
    private boolean hasNextPage;
    private List<T> list;
    /*搜索结果总页数*/
    private int pages;
    /*展示页数*/
    private int navigatePages;
    /*页号数组*/
    private int[] navigatepageNums;

    public Page() {

        this.hasPreviousPage = false;
        this.hasNextPage = false;
    }

    public Page(List<T> list, int currentPage, long count) {
        this(list, currentPage, count, 8);
    }

    public Page(List<T> list, int currentPage, long count, int navigatePages) {

        this.hasPreviousPage = false;
        this.hasNextPage = false;
        this.currentPage = currentPage;
        //this.pages = list.size()/pageSize;
        this.pages = (int) (count / pageSize + 1);
        this.navigatePages = navigatePages;
        this.list = list;
        this.calcNavigatepageNums();
        this.calcPage();
        this.judgePageBoudary();
    }

    //计算需要显示显示页号
    public void calcNavigatepageNums() {

        //小于满页时，直接返回所有页数
        if (pages <= navigatePages) {
            this.navigatepageNums = new int[this.pages];
            for (int i = 1; i <= this.pages; ++i) {
                this.navigatepageNums[i - 1] = i;
            }
        } else {
            int startNum = this.currentPage - this.navigatePages / 2;
            int endNum = this.currentPage + this.navigatePages / 2;
            this.navigatepageNums = new int[this.navigatePages];
            if (currentPage < this.navigatePages) {
                for (int i = 1; i <= this.navigatePages; i++) {
                    this.navigatepageNums[i - 1] = i;
                }
            }
            //endNum大于总页数，从显示最后的页数
            else if (endNum > this.pages) {
                endNum = this.pages;
                for (int i = this.navigatePages; i >= 1; --i) {
                    this.navigatepageNums[i - 1] = endNum--;
                }
            }
            //在中间
            else {
                for (int i = 0; i < this.navigatePages; ++i) {
                    this.navigatepageNums[i] = startNum++;
                }
            }

        }
    }

    private void calcPage() {
        //不为null，长度大于0，初始化第一页、尾页、上一页、下一页
        if (this.navigatepageNums != null && this.navigatepageNums.length > 0) {
            this.firstPage = this.navigatepageNums[0];
            this.lastPage = this.navigatepageNums[this.navigatepageNums.length - 1];
            if (this.currentPage > 1) {
                this.prePage = this.currentPage - 1;
            }

            if (this.currentPage < this.pages) {
                this.nextPage = this.currentPage + 1;
            }
        }

    }

    //计算边界一看就懂
    private void judgePageBoudary() {

        this.hasPreviousPage = this.currentPage > 1;
        this.hasNextPage = this.currentPage < this.pages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }


    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int[] getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }
}
