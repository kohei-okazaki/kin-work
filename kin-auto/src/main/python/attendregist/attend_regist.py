# -*- coding:utf-8 -*-
'''
Created on 2020/01/18
勤怠登録を行うPython

@since 1.0.0

'''
from time import sleep


class AttendRegist():

    def __init__(self, driver, index, workStartHour, workStartMinute,
                 workEndHour, workEndMinute):
        '''
        Constructor
        '''
        self.driver = driver
        self.index = index
        self.workStartHour = workStartHour
        self.workStartMinute = workStartMinute
        self.workEndHour = workEndHour
        self.workEndMinute = workEndMinute

    def doRegist(self):
        '''
        勤怠情報登録処理
        '''

        inputWorkStartHour = self.driver.find_element_by_name('registFormList[' + self.index + '].workStartHour')
        inputWorkStartHour.send_keys(self.workStartHour)

        inputWorkStartMinute = self.driver.find_element_by_name('registFormList[' + self.index + '].workStartMinute')
        inputWorkStartMinute.send_keys(self.workStartMinute)

        inputWorkEndHour = self.driver.find_element_by_name('registFormList[' + self.index + '].workEndHour')
        inputWorkEndHour.send_keys(self.workEndHour)

        inputWorkEndMinute = self.driver.find_element_by_name('registFormList[' + self.index + '].workEndMinute')
        inputWorkEndMinute.send_keys(self.workEndMinute)

        # 読み込みを待つために2秒間処理を止める
        sleep(2)

        # 確認ボタン押下し、勤怠登録確認画面に遷移
        self.driver.find_element_by_name('submit').click()
