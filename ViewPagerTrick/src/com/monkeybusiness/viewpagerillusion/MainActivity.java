package com.monkeybusiness.viewpagerillusion;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends FragmentActivity 
{
	private static boolean isLeftPagerScrolling = false;
	private static boolean isRightPagerScrolling = false;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final ViewPager pagerLeft = (ViewPager) findViewById(R.id.pager_left);
        pagerLeft.setAdapter(new ChildFragmentLeftPagerAdapter(getSupportFragmentManager()));
        
        final ViewPager pagerRight = (ViewPager) findViewById(R.id.pager_right);
        pagerRight.setAdapter(new ChildFragmentRightPagerAdapter(getSupportFragmentManager()));
        
        
        pagerLeft.setOnTouchListener(new View.OnTouchListener() 
        {
        	private float formerX;
        	
			public boolean onTouch(View v, MotionEvent event) 
			{
				switch(event.getAction())
				{
					case MotionEvent.ACTION_DOWN:
					{
						formerX = event.getX();
						
						break;
					}
					case MotionEvent.ACTION_MOVE:
					{
						if(isLeftPagerScrolling)
						{
							float dragX = event.getX() - formerX;
							
							if(!pagerRight.isFakeDragging())
							{
								pagerRight.beginFakeDrag();
							}
							
							pagerRight.fakeDragBy(dragX);
							System.out.println("fake dragging right by " + dragX);
							
							formerX = event.getX();
						}
						
						break;
					}
					case MotionEvent.ACTION_UP:
					{
						
						break;
					}
					default:
					{
						System.out.println("Motion action not recognized!");
					}
				}
				
				return false;
			}
		});
        
        pagerRight.setOnTouchListener(new View.OnTouchListener() 
        {
        	private float formerX;
        	
			public boolean onTouch(View v, MotionEvent event) 
			{
				switch(event.getAction())
				{
					case MotionEvent.ACTION_DOWN:
					{
						formerX = event.getX();
						
						break;
					}
					case MotionEvent.ACTION_MOVE:
					{
						if(isLeftPagerScrolling)
						{
							float dragX = event.getX() - formerX;
							
							if(!pagerLeft.isFakeDragging())
							{
								pagerLeft.beginFakeDrag();
							}
							
							pagerLeft.fakeDragBy(dragX);
							System.out.println("fake dragging left by " + dragX);
							
							formerX = event.getX();
						}
						
						break;
					}
					case MotionEvent.ACTION_UP:
					{
						
						break;
					}
					default:
					{
						System.out.println("Motion action not recognized!");
					}
				}
				
				return false;
			}
		});
        
        pagerLeft.setOnPageChangeListener(new ViewPager.OnPageChangeListener() 
        {	
			public void onPageSelected(int arg0) {}
			
			public void onPageScrolled(int arg0, float arg1, int arg2) {}
			
			public void onPageScrollStateChanged(int scrollState) 
			{				
				if(scrollState == ViewPager.SCROLL_STATE_IDLE)
				{
					isLeftPagerScrolling = false;
					
					if(pagerRight.isFakeDragging())
					{
						pagerRight.endFakeDrag();
					}
				}
				else
				{
					isLeftPagerScrolling = true;
					
					if(!pagerRight.isFakeDragging())
					{
						pagerRight.beginFakeDrag();
						
						System.out.println("starting fake drag");
					}
				}
				
				System.out.println("Left scrolling" + isLeftPagerScrolling); 
			}
		});
        
        pagerRight.setOnPageChangeListener(new ViewPager.OnPageChangeListener() 
        {	
			public void onPageSelected(int arg0) {}
			
			public void onPageScrolled(int arg0, float arg1, int arg2) {}
			
			public void onPageScrollStateChanged(int scrollState) 
			{
				if(scrollState == ViewPager.SCROLL_STATE_IDLE)
				{					
					if(pagerLeft.isFakeDragging())
					{
						pagerLeft.endFakeDrag();
					}
					
					isRightPagerScrolling = false;
				}
				else
				{	
					if(!pagerLeft.isFakeDragging())
					{
						pagerLeft.beginFakeDrag();
					}
					
					isRightPagerScrolling = true;
				}
				
				System.out.println("Right scrolling " + isRightPagerScrolling);
			}
		});
    }
}