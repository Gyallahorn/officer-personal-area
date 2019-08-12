package com.example.healthyworker

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.victorx64.officerpersonalarea.Data.User
//import com.victorx64.officerpersonalarea.ProfileSingletone
import com.victorx64.officerpersonalarea.R
import com.victorx64.officerpersonalarea.Retrofit.MinzdravApi
import kotlinx.android.synthetic.main.my_profile_fragment_layout.*
import org.jetbrains.anko.support.v4.find
import com.victorx64.officerpersonalarea.Retrofit.MinzdravUser as MinzdravUser1

class ProfileFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {

    }

    private var mProfileNameEdit: EditText? = null
    private var mProfileGenderRadioGroup: RadioButton? = null
    private var mProfileAgeSpinner: Spinner? = null
    private var mProfileWorkPlace: Spinner? = null
    private var mProfileSnilsEdit: EditText? = null
    private var mProfilePolisEdit: EditText? = null
    val minzdrav = MinzdravApi.sendUser()

    private var mProfileSaveButton: Button? = null


    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //  ProfileSingletone.getInstance()?.GetUser { user -> parseResponce(user as MinzdravUser1)

        inflater.inflate(R.layout.my_profile_fragment_layout, container, false)
        mProfileNameEdit = find(R.id.editName) as? EditText
        mProfileGenderRadioGroup = find(R.id.profile_gender_radio_group) as? RadioButton
        mProfileAgeSpinner = find(R.id.profile_age_spinner) as? Spinner
        mProfileWorkPlace = find(R.id.profile_work_spinner) as? Spinner
        mProfilePolisEdit = find(R.id.editPolis) as? EditText
        mProfileSnilsEdit = find(R.id.editSnils) as? EditText
        mProfileSaveButton = find(R.id.profile_save_button) as? Button
        createUserBody()
        mProfileSaveButton!!.setOnClickListener { minzdrav.postUser(idToken = "sadsad",mUSER ) }
        return view
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

//
//    private fun sendNewUserData() {
//        val user = createUserBody()
//        RetrofitSingletone.getInstance().PostUser(object : retrofit2.Callback<MinzdravUser1> {
//            override fun onResponse(call: Call<MinzdravUser1>, response: Response<MinzdravUser1>) {
//                if (response.isSuccessful) {
//                    Log.d(TAG, " get successful response  when send new user data")
//                    //response.body()?.let { ProfileSingletone.getInstance()?.SetUser(it) }
//                    toast("Данные сохранены")
//                } else {
//                    Log.d(TAG, " get fail response  when send new user data")
//                    toast("Не удалось сохранить данные")
//                }
//            }
//
//            override fun onFailure(call: Call<MinzdravUser1>, t: Throwable) {
//                toast("Ошибка соединения")
//            }
//        }, user)
//    }
//

    fun createUserBody(): User {
        val body = User(IdToken = String(), Name = String(), Gender = true, age = String(), Polis = String(), Snils = String(), Work = String())
        body.Name = mProfileNameEdit?.text.toString()
        body.age = profile_age_spinner.selectedItem.toString()
        body.Work = profile_work_spinner.selectedItem.toString()
        body.Polis= mProfilePolisEdit?.text.toString()
        body.Snils=mProfileSnilsEdit?.text.toString()

        val mUSER = body

                return body
    }

//    private fun parseResponce(user: MinzdravUser1) {
//        Log.d(TAG, "Start Parsing")
//        try {
//            val userName = user.name
//            // textViewId its temporary
//            (find<View>(R.id.textViewID) as TextView).text = userName
//            mProfileGenderRadioGroup!!.clearFocus()
//            if (user.gender != null) {
//                val gender = if (user.gender!!) R.id.radioButton_Male else R.id.radioButton_Fem
//                mProfileGenderRadioGroup!!.isChecked
//            }
//            mProfileWorkPlace?.setSelection((mProfileWorkPlace?.adapter as ArrayAdapter<String>).getPosition(user.age))
//            mProfileSnilsEdit?.setText(user.snils)
//            mProfilePolisEdit?.setText(user.polis)
//            mProfileAgeSpinner?.setSelection((mProfileAgeSpinner?.adapter as ArrayAdapter<String>).getPosition(user.age))
//            mProfileNameEdit?.setText(user.name)
//
//        } catch (e: Exception) {
//            Log.d("TAG", "Json parsingError" + e.message)
//            toast("Ошибка")
//        }
//    }

}