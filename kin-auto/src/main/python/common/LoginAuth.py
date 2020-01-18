#-*- coding:utf-8 -*-
'''
Created on 2020/01/18
ログイン処理を行うPython

@since 1.0.0

'''
from time import sleep
from src.main.python.common import ConstData

class LoginAuth():

    def __init__(self, driver, loginId, password):
        '''
        Constructor
        '''
        self.driver = driver
        self.loginId = loginId
        self.password = password


    def login(self):

        # ログイン画面を表示する
        self.driver.get(ConstData.BASE_REQUEST_URL + '/login/index')

        # ログイン画面 - loginIdを設定
        loginIdElement = self.driver.find_element_by_id("loginId")
        loginIdElement.send_keys(self.loginId)

        # ログイン画面 - passwordを設定
        passwordElement = self.driver.find_element_by_id("password")
        passwordElement.send_keys(self.password)

        # 読み込みを待つために2秒間処理を止める
        sleep(2)

        # ログインボタン押下し、TOP画面へ遷移
        submitButton = self.driver.find_element_by_id("submit")
        submitButton.click()

        # 読み込みを待つために2秒間処理を止める
        sleep(2)
