class Solution {
    public int findLength(ListNode head){
        int len=0;
        while(head!=null){
            head=head.next;
            len++;
        }
          
        
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return null;
        int len=findLength(head);
        k=k%len;
        ListNode fast=head,slow=head;
        while(k!=0){
           fast=fast.next;
            k--;
        }
            
        
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=head;
        head=slow.next;
        slow.next=null;
        
        return head;
        
    }
}