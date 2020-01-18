# -*- coding:utf-8 -*-
'''
Created on 2020/01/18
定時情報を登録するPython

@since 1.0.0
'''
from time import sleep


class OntimeRegist():

    def __init__(self, driver, companyCode, workStartHour, workStartMinute, workEndHour, workEndMinute):
        '''
        Constructor
        '''
        self.driver = driver
        self.companyCode = companyCode
        self.workStartHour = workStartHour
        self.workStartMinute = workStartMinute
        self.workEndHour = workEndHour
        self.workEndMinute = workEndMinute

    def doRegist(self):
        '''
        定時情報登録処理
        '''

        # 定時登録画面 - 企業コード
        inputCompanyCode = self.driver.find_element_by_id("companyCode")
        inputCompanyCode.send_keys(self.companyCode)
        # 定時登録画面 - 始業時間(時)
        inputWorkStartHour = self.driver.find_element_by_id("workStartHour")
        inputWorkStartHour.send_keys(self.workStartHour)
        # 定時登録画面 - 始業時間(分)
        inputWorkStartMinute = self.driver.find_element_by_id("workStartMinute")
        inputWorkStartMinute.send_keys(self.workStartMinute)
        # 定時登録画面 - 終業時間(時)
        inputWorkEndHour = self.driver.find_element_by_id("workEndHour")
        inputWorkEndHour.send_keys(self.workEndHour)
        # 定時登録画面 - 終業時間(分)
        inputWorkEndMinute = self.driver.find_element_by_id("workEndMinute")
        inputWorkEndMinute.send_keys(self.workEndMinute)

        # 読み込みを待つために2秒間処理を止める
        sleep(2)

        # 確認ボタン押下し、定時登録確認画面へ遷移
        self.driver.find_element_by_id("submit").click()
