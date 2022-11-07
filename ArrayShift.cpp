//Array Shift, Time Complexity = O(n) and space complexity = O(n),Testcase 1: {2,7,4,6,1,3},p=3,d=0,Testcase 2:{2,7,4,6,1,3},p=2,d=1

#include<bits/stdc++.h>
using namespace std;

void display(int res[],int len){
	cout<<"result array"<<endl;
	for(int i=0;i<len;i++){
		cout<<res[i]<<" ";
	}
}

void shift(int arr[],int len,int pos,int dir){
	int bArray[len],size=0;
	int start;
	cout<<"len = "<<len<<" pos = "<<pos<<" dir = "<<dir<<endl;
	cout<<"given array:"<<endl;
	for(int j=0;j<len;j++){
		cout<<arr[j]<<" ";
	}
	if(dir==0){
		for(int i=pos;i<len;i++){
			bArray[size]=arr[i];
			size++;
		}
		for(int j=0;j<pos;j++){
			bArray[size]=arr[j];
			size++;
		}
	}
	else{
		//To get the predecessor 
		start= len-pos;
		for(int i=start;i<len;i++){
			bArray[size]=arr[i];
			size++;
		}
		for(int j=0;j<start;j++){
			bArray[size]=arr[j];
			size++;
		}
	}
	cout<<endl;
	display(bArray,len);
}

int main(){
	
	int n;
	char ch='y';
	cout<<"Enter value of n"<<endl;
	cin>>n;
	int a[n],d,p;
	for(int i=0;i<n;i++){
		cin>>a[i];
	}
	while(ch=='y'){
		cout<<"Enter value of p"<<endl;
		cin>>p;
		if(p>0 && p<n){
			break;
		}
	}
	while(ch=='y'){
		cout<<"Enter value of d"<<endl;
		cin>>d;
		if(d==0 || d==1){
			break;
		}
	}
	
	shift(a,n,p,d);
}
