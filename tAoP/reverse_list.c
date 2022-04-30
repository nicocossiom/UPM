

struct ListNode
{
    int value;
    struct ListNode *sig;
};

struct ListNode* reverse(struct ListNode* head){
    if ( head == 0 || head->sig == 0){
        return head;
    }
    else{
        struct ListNode *newHead;
        struct ListNode *last = head->sig;
        newHead = reverse(head->sig);
        last->sig = head;
        head-> = NULL;
        return newHead;
    }
}