#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include”Dictionary.h”


// private types --------------------------------------------------------------

// NodeObj
typedef struct NodeObj{
	char key;
	char val;
   struct NodeObj* next;
} NodeObj;

// Node
typedef NodeObj* Node;

// newNode()
// constructor of the Node type
Node newNode(char k, char v) {
   Node N = malloc(sizeof(NodeObj));
   assert(N!=NULL);
   N->key = key;
	N->val = value;
   N->next = NULL;
   return(N);
}

// freeNode()
// destructor for the Node type
void freeNode(Node* pN){
   if( pN!=NULL && *pN!=NULL ){
      free(*pN);
      *pN = NULL;
   }
}


// DictionaryObj
typedef struct DictionaryObj{
   Node top;
   int numItems;
	char key;
	char val;
} DictionaryObj;


// public functions -----------------------------------------------------------

// newDictionary()
Dictionary newDictionary(void){
   Dictionary D = malloc(sizeof(DictionaryObj));
   assert(D!=NULL);
   D->top = NULL;
   D->numItems = 0;
	D->key = NULL;
	D->val = NULL;
   return D;
}

// freeDictionary()
void freeDictionary(Dictionary* pD){
   if( pD!=NULL && *pD!=NULL ){
      if( !isEmpty(*pD) ) makeEmpty(*pD);
      free(*pD);
      *pD = NULL;
   }
}

//findkey?
Node findKey(char* k){
	Node N;
	while(N->next != NULL){
		if(strcmp(N->next->key, k) == 0){
			return N;
		}
		N->next;
	}
	return NULL;
}

// isEmpty()
int isEmpty(Dictionary D){
   if( D==NULL ){
      fprintf(stderr, 
              "Error: calling isEmpty() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   return(D->numItems==0);
}

// size()
int size(Dictionary D){
	if( D==NULL ){
      fprintf(stderr, 
              "Error: calling size() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   return(numItems);
}

char* lookup(Dictionary D, char* k){
	Node N;
	N = findKey(k);
	if(N != NULL){
	return N->key;
	}
	fprintf(stderr, 
              "Error: calling lookup() on NULL Dictionary reference\n");
}

void insert(Dictionary D, char* k, char* v){
	Node N;
	if(lookup(k) != NULL){
			if(N == NULL){
				N = newNode(k, v);
				numItems++;
			}
			else{
				while(N->next != null){
					N = N->next;
				}
				N->next = newNode(k, v);
				numItems++;
			}
		}
		else{
			fprintf(stderr, 
              "Error: calling insert() on NULL Dictionary reference\n");
		}
}

void delete(Dictionary D, char* k){
	Node N;
	if(lookup(k) != NULL){
			if(numItems == 1) {
				N = null;
				numItems--;
			}
			else if(N == findKey(key)) {
				N = N->next;
				numItems--;
			}
			else {
				while(N != NULL && N->next != NULL) {
					if(strcmp(N->next->k, k) == 0) {
								if(N->next->next == null) {
									N->next = NULL;
									numItems--;
								}
								else {
									Node A = N;
									Node B = A->next;
									A->next = B->next;
									B->next = NULL;
									numItems--;
								}
					}
					N = N->next;
				}
			}
		}
		else{
			fprintf(stderr, 
              "Error: calling delete() on NULL Dictionary reference\n");
		}
}

// makeEmpty()
void makeEmpty(Dictionary D){
   if( D==NULL ){
      fprintf(stderr, 
              "Error: calling makeEmpty() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   if( D->numItems==0 ){
      fprintf(stderr, "Error: calling makeEmpty() on empty Stack\n");
      exit(EXIT_FAILURE);
   }
   D->top = NULL;
   D->numItems = 0;
	D->k = NULL;
	D->v = NULL;
	
}

// printDictionary()
void printDictionary(FILE* out, Dictionary D){
   Node N;
   if( D==NULL ){
      fprintf(stderr, 
              “Error: calling printDictionry() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   for(N=S->top; N!=NULL; N=N->next){ fprintf(out, “key=%d value=%d”, N->key, N->val); }
   fprintf(out, "\n");
}
