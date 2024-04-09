package com.ilyes.firebaseauth.auth.forgot_password;

import com.ilyes.firebaseauth.domain.repository.AuthRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ForgotPasswordViewModel_Factory implements Factory<ForgotPasswordViewModel> {
  private final Provider<AuthRepository> repoProvider;

  public ForgotPasswordViewModel_Factory(Provider<AuthRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public ForgotPasswordViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static ForgotPasswordViewModel_Factory create(Provider<AuthRepository> repoProvider) {
    return new ForgotPasswordViewModel_Factory(repoProvider);
  }

  public static ForgotPasswordViewModel newInstance(AuthRepository repo) {
    return new ForgotPasswordViewModel(repo);
  }
}
